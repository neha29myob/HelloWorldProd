$(aws ecr get-login --no-include-email --region ap-southeast-2)
docker pull 451515956712.dkr.ecr.ap-southeast-2.amazonaws.com/neha-hello-world:latest &&
docker run -p 8000:8000 451515956712.dkr.ecr.ap-southeast-2.amazonaws.com/neha-hello-world

