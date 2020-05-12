FROM it.alfonsodomenici/wildfly:19
COPY ./target/mp-keycloak.war ${DEPLOYMENT_DIR}
