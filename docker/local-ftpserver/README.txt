# Execute the following command to run the ftp server
docker run -it --name local-ftpserver -p 21:21 akogut/docker-pyftpdlib python ftpd.py --user faizaz --password password