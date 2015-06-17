/*
 * Copyright 2015-2020 MSUN.comm All right reserved. This software is the confidential and proprietary information of
 * MSUN.comm ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with MSUN.comm.
 */
package com.fengduo.spark.commons.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * 不知为何Shiro一直不提供HasAnyPermissions的Tag.
 * 
 * @author zxc May 28, 2015 11:17:41 AM
 */
public class HasAnyPermissionsTag extends PermissionTag {

    private static final long   serialVersionUID           = -8786931833148680306L;

    private static final String PERMISSION_NAMES_DELIMETER = ",";

    @Override
    protected boolean showTagBody(String permissionNames) {
        boolean hasAnyPermission = false;

        Subject subject = getSubject();

        if (subject != null) {
            // Iterate through permissions and check to see if the user has one of the permissions
            for (String permission : permissionNames.split(PERMISSION_NAMES_DELIMETER)) {

                if (subject.isPermitted(permission.trim())) {
                    hasAnyPermission = true;
                    break;
                }

            }
        }
        return hasAnyPermission;
    }
}
