# BUILD DOCKER Image

cd /where/Dockerfile/is
docker build -t faizaz/spp-3-2-0 .

# Execute docker image

docker run -it --name local-spp-3-2-0-debug -p 8080:8080 -p 9990:9990 -p 8787:8787 faizaz/spp-3-2-0