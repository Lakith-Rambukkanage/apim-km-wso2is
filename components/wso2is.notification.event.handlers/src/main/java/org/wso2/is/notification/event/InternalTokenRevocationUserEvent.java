/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.is.notification.event;

import org.wso2.is.notification.NotificationConstants;

import java.util.Map;
import java.util.UUID;

/**
 * Internal Token Revocation User Event Model
 */
public class InternalTokenRevocationUserEvent extends Event {
    private static final long serialVersionUID = 1L;

    private String subjectId;
    private String subjectIdType;
    private long revocationTime;
    private String organization;

    public InternalTokenRevocationUserEvent(String subjectId, String subjectIdType, Map<String, Object> params) {

        this.eventId = UUID.randomUUID().toString();
        this.timeStamp = System.currentTimeMillis();
        this.type = NotificationConstants.INTERNAL_TOKEN_REVOCATION_USER_EVENT;
        this.tenantId = (int) params.get("tenantId");
        this.tenantDomain = params.get("tenantDomain").toString();
        this.subjectId = subjectId;
        this.subjectIdType = subjectIdType;
        this.revocationTime = (long) params.get("revocationTime");
        this.organization = params.get("organization").toString();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectIdType() {
        return subjectIdType;
    }

    public void setSubjectIdType(String subjectIdType) {
        this.subjectIdType = subjectIdType;
    }

    public long getRevocationTime() {
        return revocationTime;
    }

    public void setRevocationTime(long revocationTime) {
        this.revocationTime = revocationTime;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {

        return "InternalTokenRevocationUserEvent{" +
                ", eventId='" + eventId + '\'' +
                ", tenantId=" + tenantId + '\'' +
                ", timeStamp=" + timeStamp + '\'' +
                ", tenantDomain='" + tenantDomain + '\'' +
                ", type='" + type + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", subjectIdType='" + subjectIdType + '\'' +
                ", revocationTime=" + revocationTime + '\'' +
                ", organization=" + organization + '\'' +
                '}';
    }
}
