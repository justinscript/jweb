/*
 * Copyright 2015-2020 MSUN.com All right reserved. This software is the confidential and proprietary information of
 * MSUN.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.com.
 */
package com.fengduo.spark.commons.core.utils;

import java.util.Date;

/**
 * 日期提供者，使用它而不是直接取得系统时间，方便测试。
 * 
 * @author zxc May 28, 2015 4:06:35 PM
 */
public interface Clock {

	static final Clock DEFAULT = new DefaultClock();

	Date getCurrentDate();

	long getCurrentTimeInMillis();

	/**
	 * 默认时间提供者，返回当前的时间，线程安全。
	 */
	public static class DefaultClock implements Clock {

		@Override
		public Date getCurrentDate() {
			return new Date();
		}

		@Override
		public long getCurrentTimeInMillis() {
			return System.currentTimeMillis();
		}
	}

	/**
	 * 可配置的时间提供者，用于测试.
	 */
	public static class MockClock implements Clock {

		private long time;

		public MockClock() {
			this(0);
		}

		public MockClock(Date date) {
			this.time = date.getTime();
		}

		public MockClock(long time) {
			this.time = time;
		}

		@Override
		public Date getCurrentDate() {
			return new Date(time);
		}

		@Override
		public long getCurrentTimeInMillis() {
			return time;
		}

		/**
		 * 重新设置日期。
		 */
		public void update(Date newDate) {
			time = newDate.getTime();
		}

		/**
		 * 重新设置时间。
		 */
		public void update(long newTime) {
			this.time = newTime;
		}

		/**
		 * 滚动时间.
		 */
		public void increaseTime(int millis) {
			time += millis;
		}

		/**
		 * 滚动时间.
		 */
		public void decreaseTime(int millis) {
			time -= millis;
		}
	}

}