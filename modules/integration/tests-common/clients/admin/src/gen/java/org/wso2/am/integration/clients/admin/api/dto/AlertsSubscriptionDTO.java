/*
 * WSO2 API Manager - Admin
 * This document specifies a **RESTful API** for WSO2 **API Manager** - Admin Portal. Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.5.176/components/apimgt/org.wso2.carbon.apimgt.rest.api.admin/src/main/resources/admin-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: v1.2
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.admin.api.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.wso2.am.integration.clients.admin.api.dto.AlertTypeDTO;

/**
 * AlertsSubscriptionDTO
 */

public class AlertsSubscriptionDTO {
  @SerializedName("alerts")
  private List<AlertTypeDTO> alerts = null;

  @SerializedName("emailList")
  private List<String> emailList = null;

  public AlertsSubscriptionDTO alerts(List<AlertTypeDTO> alerts) {
    this.alerts = alerts;
    return this;
  }

  public AlertsSubscriptionDTO addAlertsItem(AlertTypeDTO alertsItem) {
    if (this.alerts == null) {
      this.alerts = new ArrayList<>();
    }
    this.alerts.add(alertsItem);
    return this;
  }

   /**
   * Get alerts
   * @return alerts
  **/
  @ApiModelProperty(value = "")
  public List<AlertTypeDTO> getAlerts() {
    return alerts;
  }

  public void setAlerts(List<AlertTypeDTO> alerts) {
    this.alerts = alerts;
  }

  public AlertsSubscriptionDTO emailList(List<String> emailList) {
    this.emailList = emailList;
    return this;
  }

  public AlertsSubscriptionDTO addEmailListItem(String emailListItem) {
    if (this.emailList == null) {
      this.emailList = new ArrayList<>();
    }
    this.emailList.add(emailListItem);
    return this;
  }

   /**
   * Get emailList
   * @return emailList
  **/
  @ApiModelProperty(value = "")
  public List<String> getEmailList() {
    return emailList;
  }

  public void setEmailList(List<String> emailList) {
    this.emailList = emailList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlertsSubscriptionDTO alertsSubscription = (AlertsSubscriptionDTO) o;
    return Objects.equals(this.alerts, alertsSubscription.alerts) &&
        Objects.equals(this.emailList, alertsSubscription.emailList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alerts, emailList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlertsSubscriptionDTO {\n");
    
    sb.append("    alerts: ").append(toIndentedString(alerts)).append("\n");
    sb.append("    emailList: ").append(toIndentedString(emailList)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

