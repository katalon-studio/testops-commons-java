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
import org.threeten.bp.LocalDate;

import java.util.Objects;

/**
 * ReleaseResource
 */


public class ReleaseResource {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("startTime")
  private LocalDate startTime = null;

  @JsonProperty("endTime")
  private LocalDate endTime = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("projectId")
  private Long projectId = null;

  @JsonProperty("closed")
  private Boolean closed = null;

  @JsonProperty("externalRelease")
  private ExternalReleaseResource externalRelease = null;

  @JsonProperty("releaseStatistics")
  private ReleaseStatisticsResource releaseStatistics = null;

  public ReleaseResource id(Long id) {
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

  public ReleaseResource name(String name) {
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

  public ReleaseResource startTime(LocalDate startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @Schema(description = "")
  public LocalDate getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDate startTime) {
    this.startTime = startTime;
  }

  public ReleaseResource endTime(LocalDate endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * Get endTime
   * @return endTime
  **/
  @Schema(description = "")
  public LocalDate getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDate endTime) {
    this.endTime = endTime;
  }

  public ReleaseResource description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ReleaseResource projectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * Get projectId
   * @return projectId
  **/
  @Schema(description = "")
  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public ReleaseResource closed(Boolean closed) {
    this.closed = closed;
    return this;
  }

   /**
   * Get closed
   * @return closed
  **/
  @Schema(description = "")
  public Boolean isClosed() {
    return closed;
  }

  public void setClosed(Boolean closed) {
    this.closed = closed;
  }

  public ReleaseResource externalRelease(ExternalReleaseResource externalRelease) {
    this.externalRelease = externalRelease;
    return this;
  }

   /**
   * Get externalRelease
   * @return externalRelease
  **/
  @Schema(description = "")
  public ExternalReleaseResource getExternalRelease() {
    return externalRelease;
  }

  public void setExternalRelease(ExternalReleaseResource externalRelease) {
    this.externalRelease = externalRelease;
  }

  public ReleaseResource releaseStatistics(ReleaseStatisticsResource releaseStatistics) {
    this.releaseStatistics = releaseStatistics;
    return this;
  }

   /**
   * Get releaseStatistics
   * @return releaseStatistics
  **/
  @Schema(description = "")
  public ReleaseStatisticsResource getReleaseStatistics() {
    return releaseStatistics;
  }

  public void setReleaseStatistics(ReleaseStatisticsResource releaseStatistics) {
    this.releaseStatistics = releaseStatistics;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReleaseResource releaseResource = (ReleaseResource) o;
    return Objects.equals(this.id, releaseResource.id) &&
        Objects.equals(this.name, releaseResource.name) &&
        Objects.equals(this.startTime, releaseResource.startTime) &&
        Objects.equals(this.endTime, releaseResource.endTime) &&
        Objects.equals(this.description, releaseResource.description) &&
        Objects.equals(this.projectId, releaseResource.projectId) &&
        Objects.equals(this.closed, releaseResource.closed) &&
        Objects.equals(this.externalRelease, releaseResource.externalRelease) &&
        Objects.equals(this.releaseStatistics, releaseResource.releaseStatistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, startTime, endTime, description, projectId, closed, externalRelease, releaseStatistics);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReleaseResource {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    closed: ").append(toIndentedString(closed)).append("\n");
    sb.append("    externalRelease: ").append(toIndentedString(externalRelease)).append("\n");
    sb.append("    releaseStatistics: ").append(toIndentedString(releaseStatistics)).append("\n");
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
