/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 *  WSO2 API Manager - Publisher API
 *  This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.0.4/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification.
 *
 *  OpenAPI spec version: 0.10.0
 *  Contact: architecture@wso2.com
 *
 *  NOTE: This class is auto generated by the swagger code generator program.
 *  https://github.com/swagger-api/swagger-codegen.git
 *  Do not edit the class manually.
 *
 */

package org.wso2.carbon.apimgt.rest.integration.tests.api.publisher;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.SubscriptionCollectionApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.APIIndividualApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.APICollectionApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.ApiException;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.APIList;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.SubscriptionList;

/**
 * API tests for SubscriptionCollectionApi
 */
public class SubscriptionCollectionApiIT {

    private final SubscriptionCollectionApi api = new SubscriptionCollectionApi();
    private final APIIndividualApi apiIndividualApi = new APIIndividualApi();
    private final APICollectionApi apiCollectionApi = new APICollectionApi();

    private String APIID = null;

    @BeforeClass
    public void beforeClass() throws ApiException {

        // Create an API for testing
        /*API body = new API();
        String contentType = "application/json";

        body.setName("IndivAPI");
        body.setContext("iapi");
        body.setVersion("1.0.0");
        body.setProvider("admin");
        body.setLifeCycleStatus("CREATED");
        body.setTransport(new ArrayList<String>() {{
            add("http");
        }});
        body.setCacheTimeout(100);
        body.setPolicies(new ArrayList<String>() {{
            add("Unlimited");
        }});
        body.setVisibility(API.VisibilityEnum.PUBLIC);
        body.setTags(new ArrayList<String>());
        body.setVisibleRoles(new ArrayList<String>());
        body.setVisibleTenants(new ArrayList<String>());
        body.setSequences(new ArrayList<Sequence>());
        body.setBusinessInformation(new APIBusinessInformation());
        body.setCorsConfiguration(new APICorsConfiguration());
        API response = apiCollectionApi.apisPost(body);
        APIID = response.getId();

        apiIndividualApi.apisChangeLifecyclePost("Published", APIID, null, null, null);
*/
    }

    /**
     * Get all Subscriptions
     * <p>
     * This operation can be used to retrieve a list of subscriptions of the user associated with the provided access token. This operation is capable of  1. Retrieving all subscriptions for the user&#39;s APIs. &#x60;GET https://127.0.0.1:9443/api/am/publisher/v0.10/subscriptions&#x60;  2. Retrieving subscriptions for a specific API. &#x60;GET https://127.0.0.1:9443/api/am/publisher/v0.10/subscriptions?apiId&#x3D;c43a325c-260b-4302-81cb-768eafaa3aed&#x60;
     *
     * @throws ApiException if the Api call fails
     */
    @Test(enabled = false)
    public void subscriptionsGetTest() throws ApiException {

        String apiId = APIID;
        Integer limit = 2;
        Integer offset = 0;
        String ifNoneMatch = null;
        SubscriptionList response = api.subscriptionsGet(APIID, limit, offset, ifNoneMatch);
        System.out.println(response);

        // TODO: test validations
    }

    @AfterClass
    public void afterClass() throws ApiException {
        // remove IndivAPI version 1.1.0
        APIList response = apiCollectionApi.apisGet(1, 0, null, null);
        apiIndividualApi.apisApiIdDelete(response.getList().get(0).getId(), null, null);
    }

}
