FROM ubuntu:latest
LABEL authors="kimse"

ENTRYPOINT ["top", "-b"]