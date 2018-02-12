# Use latest jboss/base-jdk:8 image as the base 
FROM jboss/base-jdk:8

USER root
RUN mkdir /home/jboss && chown 1000:1000 /home/jboss && chmod 755 /home/jboss
USER jboss

RUN cd /opt/jboss/ \
&& curl -O ftp://10.21.16.75:21/spp-2-4-26/service-process-platform-2.4.26-standalone.tar.gz --user faizaz:password \
&& tar xf service-process-platform-2.4.26-standalone.tar.gz \
&& mv service-process-platform-2.4.26 service-process-platform-2-4-26 \
&& rm service-process-platform-2.4.26-standalone.tar.gz \
&& cd /home/jboss \
&& curl -O ftp://10.21.16.75:21/spp-2-4-26/spp-2.4.26-config.tar.gz --user faizaz:password \
&& tar xf spp-2.4.26-config.tar.gz \
&& rm spp-2.4.26-config.tar.gz \
&& /opt/jboss/service-process-platform-2-4-26/bin/add-user.sh jboss test12345! --silent \
&& cp /opt/jboss/service-process-platform-2-4-26/standalone/configuration/application-* /home/jboss/slot0/configuration/ \
&& cp /opt/jboss/service-process-platform-2-4-26/standalone/configuration/mgmt-* /home/jboss/slot0/configuration/

EXPOSE 8080 9990 8787
CMD ["/opt/jboss/service-process-platform-2-4-26/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug", "-P", "/home/jboss/slot0/spp.properties"]