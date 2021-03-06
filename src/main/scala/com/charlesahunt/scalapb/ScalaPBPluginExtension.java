package com.charlesahunt.scalapb;

import org.gradle.api.tasks.util.PatternFilterable;
import org.gradle.api.tasks.util.PatternSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScalaPBPluginExtension {
    /**
     * Things to explicitly include as dependent proto sources. These are explicitly recompiled into
     * scala. These may be .jar, .proto, .zip, almost any archive that could contain protos
     */
    List<String> externalProtoSources;

    /**
     * e.g. "-v360"
     */
    String protocVersion;

    /**
     * Place where generated case classes are placed
     */
    String targetDir;

    /**
     * This project's proto source dir. Analogous to srcDir in protobuf-gradle-plugin
     */
    String projectProtoSourceDir;

    /**
     * Place to unpack protos extracted from dependentProtoSources
     */
    String extractedIncludeDir;

    /**
     * Generate grpc stubs?
     */
    Boolean grpc;

    /**
     * Use embedded protoc?
     */
    Boolean embeddedProtoc;

    /**
     * Generate java conversion methods?
     */
    Boolean javaConversions;

    /**
     * When generating scala for proto dependencies of this project, only generate for dependent protos matching this spec
     */
    PatternSet dependencySpec;

    /**
     * If using protobuf-gradle-plugin, where are those outputs copied from (relative to project.projectDir)
     */
    String gradleProtobufExtractedPrefix;

    Boolean flatPackage;

    Boolean singleLineToProtoString;

    Boolean asciiFormatToString;


    public List<String> getExternalProtoSources() {
        return externalProtoSources;
    }

    public String getProtocVersion() {
        return protocVersion;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public String getProjectProtoSourceDir() {
        return projectProtoSourceDir;
    }

    public String getExtractedIncludeDir() {
        return extractedIncludeDir;
    }

    public Boolean getGrpc() { return grpc; }

    public Boolean getEmbeddedProtoc() { return embeddedProtoc; }

    public Boolean getJavaConversions() { return javaConversions; }

    public PatternSet getDependencySpec() { return dependencySpec; }

    public String getGradleProtobufExtractedPrefix() { return gradleProtobufExtractedPrefix; }

    public void setExternalProtoSources(List<String> externalProtoSources) {
        this.externalProtoSources = externalProtoSources;
    }

    public void setProtocVersion(String protocVersion) {
        this.protocVersion = protocVersion;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    public void setProjectProtoSourceDir(String projectProtoSourceDir) {
        this.projectProtoSourceDir = projectProtoSourceDir;
    }

    public void setExtractedIncludeDir(String extractedIncludeDir) {
        this.extractedIncludeDir = extractedIncludeDir;
    }

    public void setGrpc(boolean grpc) { this.grpc = grpc; }

    public void setEmbeddedProtoc(boolean embeddedProtoc) { this.embeddedProtoc = embeddedProtoc; }

    public void setJavaConversions(boolean javaConversions) { this.javaConversions = javaConversions; }

    public void setDependencySpec(PatternFilterable dependencySpec) { this.dependencySpec.copyFrom(dependencySpec); }

    public void setGradleProtobufExtractedPrefix(String gradleProtobufExtractedPrefix) {
        this.gradleProtobufExtractedPrefix = gradleProtobufExtractedPrefix;
    }

    public Boolean getFlatPackage() {
        return flatPackage;
    }

    public void setFlatPackage(Boolean flatPackage) {
        this.flatPackage = flatPackage;
    }

    public Boolean getSingleLineToProtoString() {
        return singleLineToProtoString;
    }

    public void setSingleLineToProtoString(Boolean singleLineToProtoString) {
        this.singleLineToProtoString = singleLineToProtoString;
    }

    public Boolean getAsciiFormatToString() {
        return asciiFormatToString;
    }

    public void setAsciiFormatToString(Boolean asciiFormatToString) {
        this.asciiFormatToString = asciiFormatToString;
    }

    public ScalaPBPluginExtension() {
        this.externalProtoSources = new ArrayList<String>();
        this.protocVersion = "-v360";
        this.targetDir = "target/scala";
        this.projectProtoSourceDir = "src/main/protobuf";
        this.extractedIncludeDir = "target/external_protos";
        this.grpc = true;
        this.embeddedProtoc = false;
        this.javaConversions = false;
        // by default, generate everything. this is how specs are expected to work, but it will take a long time.
        this.dependencySpec = new PatternSet();
        // BY CONVENTION, this is usually build/extracted-protos/$sourceSet
        // where sourceSet is usually main
        this.gradleProtobufExtractedPrefix = "build/extracted-include-protos/main";
        this.flatPackage = false;
        this.singleLineToProtoString = false;
        this.asciiFormatToString = false;
    }
}
