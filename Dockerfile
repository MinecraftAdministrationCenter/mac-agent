FROM mhart/alpine-node:11

ENV PORT 2019
ENV SECRET "IW€@rMy$unGl@ss3s@N8"
ENV ID "random-uuid-here"

WORKDIR /mac-agent
COPY . /mac-agent

RUN yarn install
RUN yarn build

CMD ["yarn", "start"]