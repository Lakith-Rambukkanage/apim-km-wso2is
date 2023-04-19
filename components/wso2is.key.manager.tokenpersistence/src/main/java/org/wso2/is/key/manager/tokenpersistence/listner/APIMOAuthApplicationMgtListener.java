/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.is.key.manager.tokenpersistence.listner;

import org.apache.commons.logging.*;
import org.wso2.carbon.identity.oauth.*;
import org.wso2.carbon.identity.oauth.dto.*;
import org.wso2.carbon.identity.oauth.listener.*;
import org.wso2.is.notification.*;
import org.wso2.is.notification.event.*;
import org.wso2.is.notification.internal.*;

import java.util.*;

public class APIMOAuthApplicationMgtListener implements OAuthApplicationMgtListener {

    private static final Log log = LogFactory.getLog(APIMOAuthApplicationMgtListener.class);


    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public int getExecutionOrder() {
        return 0;
    }

    @Override
    public void doPreUpdateConsumerApplication(OAuthConsumerAppDTO oAuthConsumerAppDTO) throws IdentityOAuthAdminException {

    }

    @Override
    public void doPreUpdateConsumerApplicationState(String s, String s1) throws IdentityOAuthAdminException {

    }

    @Override
    public void doPreRemoveOAuthApplicationData(String s) throws IdentityOAuthAdminException {

    }

    @Override
    public void doPostRevokeRegenerateOAuthSecret(String consumerKey, Properties properties)
            throws IdentityOAuthAdminException {
        InternalTokenRevocationEvent internalTokenRevocationEvent
                = new InternalTokenRevocationEvent(consumerKey, properties);
        ServiceReferenceHolder.getInstance().getEventSender().publishEvent(internalTokenRevocationEvent);
    }

}