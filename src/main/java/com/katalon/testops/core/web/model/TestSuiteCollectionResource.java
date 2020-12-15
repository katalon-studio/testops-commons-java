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

import java.util.Objects;

/**
 * TestSuiteCollectionResource
 */


public class TestSuiteCollectionResource {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("project")
  private ProjectResource project = null;

  @JsonProperty("urlId")
  private String urlId = null;

  public TestSuiteCollectionResource id(Long id) {
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

  public TestSuiteCollectionResource name(String name) {
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

  public TestSuiteCollectionResource project(ProjectResource project) {
    this.project = project;
    return this;
  }

   /**
   * Get project
   * @return project
  **/
  @Schema(description = "")
  public ProjectResource getProject() {
    return project;
  }

  public void setProject(ProjectResource project) {
    this.project = project;
  }

  public TestSuiteCollectionResource urlId(String urlId) {
    this.urlId = urlId;
    return this;
  }

   /**
   * Get urlId
   * @return urlId
  **/
  @Schema(description = "")
  public String getUrlId() {
    return urlId;
  }

  public void setUrlId(String urlId) {
    this.urlId = urlId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestSuiteCollectionResource testSuiteCollectionResource = (TestSuiteCollectionResource) o;
    return Objects.equals(this.id, testSuiteCollectionResource.id) &&
        Objects.equals(this.name, testSuiteCollectionResource.name) &&
        Objects.equals(this.project, testSuiteCollectionResource.project) &&
        Objects.equals(this.urlId, testSuiteCollectionResource.urlId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, project, urlId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestSuiteCollectionResource {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    urlId: ").append(toIndentedString(urlId)).append("\n");
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
