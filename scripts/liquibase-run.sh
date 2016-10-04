#!/usr/bin/env bash

# Interrupt execution if you try to use an uninitialised variable.
set -u

# Interrupt execution if some command returns a non-true return value.
set -e

# Use exit code of first failed command in pipeline.
# For example pipeline: cmd1 | cmd2 | cmd3. If cmd2 fails then bash will return
# exit code of cmd3 by default. If we enable option 'pipefail' and cmd2 fails
# then bash will return exit code of cmd2 command instead cmd3.
set -o pipefail

CUR_DIR="$(pwd)"
LIB_DIR="$CUR_DIR/../lib"
RESOURCES_DIR="$CUR_DIR/../resources"

CLASSPATH="$LIB_DIR/liquibase.jar:$LIB_DIR/mysql-connector-java-5.1.34.jar"

# if "$1" isn't set then use default value
PROPERTIES_FILE=${1:-$RESOURCES_DIR/liquibase.properties}

java -jar "$LIB_DIR/liquibase.jar" \
	--classpath="$CLASSPATH" \
	--defaultsFile="$PROPERTIES_FILE" \
	--changeLogFile="$RESOURCES_DIR/liquibase-changelog.xml" \
	update