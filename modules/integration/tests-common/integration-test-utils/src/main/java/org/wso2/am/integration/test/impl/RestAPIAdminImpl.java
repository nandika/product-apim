/*
 * Copyright (c) 2019, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an"AS IS"BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.am.integration.test.impl;

import org.apache.commons.lang.StringUtils;
import org.wso2.am.integration.clients.admin.ApiClient;
import org.wso2.am.integration.clients.admin.ApiException;
import org.wso2.am.integration.clients.admin.ApiResponse;
import org.wso2.am.integration.clients.admin.api.AdvancedPolicyIndividualApi;
import org.wso2.am.integration.clients.admin.api.KeyManagerCollectionApi;
import org.wso2.am.integration.clients.admin.api.KeyManagerIndividualApi;
import org.wso2.am.integration.clients.admin.api.SettingsApi;
import org.wso2.am.integration.clients.admin.api.SubscriptionPolicyCollectionApi;
import org.wso2.am.integration.clients.admin.api.SubscriptionPolicyIndividualApi;
import org.wso2.am.integration.clients.admin.api.dto.KeyManagerDTO;
import org.wso2.am.integration.clients.admin.api.dto.KeyManagerListDTO;
import org.wso2.am.integration.clients.admin.api.dto.SettingsDTO;
import org.wso2.am.integration.clients.admin.api.dto.SubscriptionThrottlePolicyDTO;
import org.wso2.am.integration.test.ClientAuthenticator;
import org.wso2.am.integration.test.HttpResponse;

/**
 * This util class performs the actions related to APIDTOobjects.
 */
public class RestAPIAdminImpl {

    public ApiClient apiAdminClient = new ApiClient();
    private KeyManagerCollectionApi keyManagerCollectionApi = new KeyManagerCollectionApi();
    private KeyManagerIndividualApi keyManagerIndividualApi = new KeyManagerIndividualApi();
    private SettingsApi settingsApi = new SettingsApi();
    private SubscriptionPolicyIndividualApi subscriptionPolicyIndividualApi = new SubscriptionPolicyIndividualApi();
    private SubscriptionPolicyCollectionApi subscriptionPolicyCollectionApi = new SubscriptionPolicyCollectionApi();
    public static final String appName = "Integration_Test_App_Admin";
    public static final String callBackURL = "test.com";
    public static final String tokenScope = "Production";
    public static final String appOwner = "admin";
    public static final String grantType = "password";
    public static final String username = "admin";
    public static final String password = "admin";
    public String tenantDomain;


    public RestAPIAdminImpl(String username, String password, String tenantDomain, String adminURl) {
        // token/DCR of Publisher node itself will be used
        String tokenURL = adminURl + "oauth2/token";
        String dcrURL = adminURl + "client-registration/v0.17/register";
        String scopeList = "openid  " +
                "apim:admin " +
                "apim:tier_view " +
                "apim:tier_manage " +
                "apim:bl_view " +
                "apim:bl_manage " +
                "apim:mediation_policy_view " +
                "apim:mediation_policy_create " +
                "apim:app_owner_change " +
                "apim:app_import_export " +
                "apim:api_import_export " +
                "apim:api_product_import_export " +
                "apim:label_manage " +
                "apim:label_read " +
                "apim:monetization_usage_publish " +
                "apim:api_workflow_approve " +
                "apim:bot_data " +
                "apim:tenantInfo " +
                "apim:tenant_theme_manage " +
                "apim:admin_operations " +
                "apim:admin_settings " +
                "apim:admin_alert_manage " +
                "apim:api_workflow_view " +
                "apim:scope_manage";

        String accessToken = ClientAuthenticator
                .getAccessToken(scopeList,
                        appName, callBackURL, tokenScope, appOwner, grantType, dcrURL, username, password, tenantDomain,
                        tokenURL);

        apiAdminClient.addDefaultHeader("Authorization", "Bearer " + accessToken);
        apiAdminClient.setBasePath(adminURl + "api/am/admin/v1");
        apiAdminClient.setDebugging(true);
        keyManagerCollectionApi.setApiClient(apiAdminClient);
        keyManagerIndividualApi.setApiClient(apiAdminClient);
        settingsApi.setApiClient(apiAdminClient);
        subscriptionPolicyIndividualApi.setApiClient(apiAdminClient);
        subscriptionPolicyCollectionApi.setApiClient(apiAdminClient);
        this.tenantDomain = tenantDomain;
    }

    public ApiResponse<KeyManagerDTO> addKeyManager(KeyManagerDTO keyManagerDTO) throws ApiException {

        return keyManagerCollectionApi.keyManagersPostWithHttpInfo(keyManagerDTO);
    }

    public KeyManagerListDTO getKeyManagers() throws ApiException {

        return keyManagerCollectionApi.keyManagersGet();
    }

    public KeyManagerDTO getKeyManager(String uuid) throws ApiException {

        return keyManagerIndividualApi.keyManagersKeyManagerIdGet(uuid);
    }

    public KeyManagerDTO updateKeyManager(String uuid, KeyManagerDTO keyManagerDTO) throws ApiException {

        return keyManagerIndividualApi.keyManagersKeyManagerIdPut(uuid, keyManagerDTO);
    }

    public void deleteKeyManager(String uuid) throws ApiException {

        keyManagerIndividualApi.keyManagersKeyManagerIdDelete(uuid);
    }

    public SettingsDTO getSettings() throws ApiException {

        return settingsApi.settingsGet();
    }

    /**
     * This method is used to create a subscription throttling policy.
     *
     * @param subscriptionThrottlePolicyDTO subscription throttling policy DTO.
     * @param contentType                   Content type.
     * @return returns the created subscription policy ID.
     * @throws ApiException Throws if an error occured while creating a new subscription policy.
     */
    public HttpResponse addSubscriptionPolicy(SubscriptionThrottlePolicyDTO subscriptionThrottlePolicyDTO, String contentType) throws ApiException {
        SubscriptionThrottlePolicyDTO subscriptionPolicyDTOResponse = subscriptionPolicyCollectionApi
                .throttlingPoliciesSubscriptionPost(subscriptionThrottlePolicyDTO, contentType);
        HttpResponse response = null;
        if (StringUtils.isNotEmpty(subscriptionPolicyDTOResponse.getPolicyId())) {
            response = new HttpResponse(subscriptionPolicyDTOResponse.getPolicyId(), 200);
        }
        return response;

    }
}
