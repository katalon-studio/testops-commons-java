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
 * TestSuiteResource
 */


public class TestSuiteResource {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("project")
  private ProjectResource project = null;

  @JsonProperty("alias")
  private String alias = null;

  @JsonProperty("lastExecutionTestSuite")
  private ExecutionTestSuiteResource lastExecutionTestSuite = null;

  @JsonProperty("urlId")
  private String urlId = null;

  public TestSuiteResource id(Long id) {
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

  public TestSuiteResource name(String name) {
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

  public TestSuiteResource path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @Schema(description = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public TestSuiteResource project(ProjectResource project) {
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

  public TestSuiteResource alias(String alias) {
    this.alias = alias;
    return this;
  }

   /**
   * Get alias
   * @return alias
  **/
  @Schema(description = "")
  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public TestSuiteResource lastExecutionTestSuite(ExecutionTestSuiteResource lastExecutionTestSuite) {
    this.lastExecutionTestSuite = lastExecutionTestSuite;
    return this;
  }

   /**
   * Get lastExecutionTestSuite
   * @return lastExecutionTestSuite
  **/
  @Schema(description = "")
  public ExecutionTestSuiteResource getLastExecutionTestSuite() {
    return lastExecutionTestSuite;
  }

  public void setLastExecutionTestSuite(ExecutionTestSuiteResource lastExecutionTestSuite) {
    this.lastExecutionTestSuite = lastExecutionTestSuite;
  }

  public TestSuiteResource urlId(String urlId) {
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
    TestSuiteResource testSuiteResource = (TestSuiteResource) o;
    return Objects.equals(this.id, testSuiteResource.id) &&
        Objects.equals(this.name, testSuiteResource.name) &&
        Objects.equals(this.path, testSuiteResource.path) &&
        Objects.equals(this.project, testSuiteResource.project) &&
        Objects.equals(this.alias, testSuiteResource.alias) &&
        Objects.equals(this.lastExecutionTestSuite, testSuiteResource.lastExecutionTestSuite) &&
        Objects.equals(this.urlId, testSuiteResource.urlId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, path, project, alias, lastExecutionTestSuite, urlId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestSuiteResource {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    lastExecutionTestSuite: ").append(toIndentedString(lastExecutionTestSuite)).append("\n");
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
