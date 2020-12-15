/*
 * Katalon TestOps API reference
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.katalon.testops.core.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/**
 * AgentResource
 */


public class AgentResource {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ip")
  private String ip = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("lastPing")
  private OffsetDateTime lastPing = null;

  @JsonProperty("os")
  private String os = null;

  @JsonProperty("teamId")
  private Long teamId = null;

  @JsonProperty("hostname")
  private String hostname = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("threshold")
  private Long threshold = null;

  @JsonProperty("numExecutingJobs")
  private Integer numExecutingJobs = null;

  @JsonProperty("numAssignedJobs")
  private Integer numAssignedJobs = null;

  @JsonProperty("agentVersion")
  private String agentVersion = null;

  @JsonProperty("deleted")
  private Boolean deleted = null;

  public AgentResource id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AgentResource name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AgentResource ip(String ip) {
    this.ip = ip;
    return this;
  }

   /**
   * Get ip
   * @return ip
  **/
  @Schema(description = "")
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public AgentResource uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @Schema(description = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public AgentResource lastPing(OffsetDateTime lastPing) {
    this.lastPing = lastPing;
    return this;
  }

   /**
   * Get lastPing
   * @return lastPing
  **/
  @Schema(description = "")
  public OffsetDateTime getLastPing() {
    return lastPing;
  }

  public void setLastPing(OffsetDateTime lastPing) {
    this.lastPing = lastPing;
  }

  public AgentResource os(String os) {
    this.os = os;
    return this;
  }

   /**
   * Get os
   * @return os
  **/
  @Schema(description = "")
  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public AgentResource teamId(Long teamId) {
    this.teamId = teamId;
    return this;
  }

   /**
   * Get teamId
   * @return teamId
  **/
  @Schema(description = "")
  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  public AgentResource hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * Get hostname
   * @return hostname
  **/
  @Schema(description = "")
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public AgentResource active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @Schema(description = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public AgentResource threshold(Long threshold) {
    this.threshold = threshold;
    return this;
  }

   /**
   * Get threshold
   * @return threshold
  **/
  @Schema(description = "")
  public Long getThreshold() {
    return threshold;
  }

  public void setThreshold(Long threshold) {
    this.threshold = threshold;
  }

  public AgentResource numExecutingJobs(Integer numExecutingJobs) {
    this.numExecutingJobs = numExecutingJobs;
    return this;
  }

   /**
   * Get numExecutingJobs
   * @return numExecutingJobs
  **/
  @Schema(description = "")
  public Integer getNumExecutingJobs() {
    return numExecutingJobs;
  }

  public void setNumExecutingJobs(Integer numExecutingJobs) {
    this.numExecutingJobs = numExecutingJobs;
  }

  public AgentResource numAssignedJobs(Integer numAssignedJobs) {
    this.numAssignedJobs = numAssignedJobs;
    return this;
  }

   /**
   * Get numAssignedJobs
   * @return numAssignedJobs
  **/
  @Schema(description = "")
  public Integer getNumAssignedJobs() {
    return numAssignedJobs;
  }

  public void setNumAssignedJobs(Integer numAssignedJobs) {
    this.numAssignedJobs = numAssignedJobs;
  }

  public AgentResource agentVersion(String agentVersion) {
    this.agentVersion = agentVersion;
    return this;
  }

   /**
   * Get agentVersion
   * @return agentVersion
  **/
  @Schema(description = "")
  public String getAgentVersion() {
    return agentVersion;
  }

  public void setAgentVersion(String agentVersion) {
    this.agentVersion = agentVersion;
  }

  public AgentResource deleted(Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

   /**
   * Get deleted
   * @return deleted
  **/
  @Schema(description = "")
  public Boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgentResource agentResource = (AgentResource) o;
    return Objects.equals(this.id, agentResource.id) &&
        Objects.equals(this.name, agentResource.name) &&
        Objects.equals(this.ip, agentResource.ip) &&
        Objects.equals(this.uuid, agentResource.uuid) &&
        Objects.equals(this.lastPing, agentResource.lastPing) &&
        Objects.equals(this.os, agentResource.os) &&
        Objects.equals(this.teamId, agentResource.teamId) &&
        Objects.equals(this.hostname, agentResource.hostname) &&
        Objects.equals(this.active, agentResource.active) &&
        Objects.equals(this.threshold, agentResource.threshold) &&
        Objects.equals(this.numExecutingJobs, agentResource.numExecutingJobs) &&
        Objects.equals(this.numAssignedJobs, agentResource.numAssignedJobs) &&
        Objects.equals(this.agentVersion, agentResource.agentVersion) &&
        Objects.equals(this.deleted, agentResource.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, ip, uuid, lastPing, os, teamId, hostname, active, threshold, numExecutingJobs, numAssignedJobs, agentVersion, deleted);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgentResource {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    lastPing: ").append(toIndentedString(lastPing)).append("\n");
    sb.append("    os: ").append(toIndentedString(os)).append("\n");
    sb.append("    teamId: ").append(toIndentedString(teamId)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
    sb.append("    numExecutingJobs: ").append(toIndentedString(numExecutingJobs)).append("\n");
    sb.append("    numAssignedJobs: ").append(toIndentedString(numAssignedJobs)).append("\n");
    sb.append("    agentVersion: ").append(toIndentedString(agentVersion)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
