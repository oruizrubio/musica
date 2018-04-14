FROM airhacks/glassfish
COPY ./target/musica.war ${DEPLOYMENT_DIR}
