# BUILD DOCKER Image

cd /where/Dockerfile/is
docker build -t faizaz/spp-2-4-26 .

# Execute docker image
docker run -it --name local-spp-2-4-26-debug -p 8080:8080 -p 9990:9990 -p 8787:8787 faizaz/spp-2-4-26