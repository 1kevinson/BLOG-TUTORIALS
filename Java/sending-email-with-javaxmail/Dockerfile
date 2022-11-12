# MailHog Dockerfile

FROM golang:1.18-alpine as builder

# Install MailHog:
RUN apk --no-cache add --virtual build-dependencies \
    git \
  && mkdir -p /root/gocode \
  && export GOPATH=/root/gocode \
  && go install github.com/mailhog/MailHog@latest

FROM alpine:3

RUN adduser -D -u 1000 mailhog

COPY --from=builder /root/gocode/bin/MailHog /usr/local/bin/

USER mailhog

WORKDIR /home/mailhog

COPY env.smtp .

ENTRYPOINT MailHog -outgoing-smtp ./env.smtp

# Expose the SMTP and HTTP ports:
EXPOSE 1025 8025