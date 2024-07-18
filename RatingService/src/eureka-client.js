const Eureka = require('eureka-js-client').Eureka;

const client = new Eureka({
  instance: {
    app: 'RATINGSERVICE',
    hostName: 'localhost',
    ipAddr: '127.0.0.1',
    statusPageUrl: 'http://localhost:8083',
    port: {
      '$': 8083,
      '@enabled': true,
    },
    vipAddress: 'nodejs-service',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
  eureka: {
    host: 'localhost',
    port: 8761,
    servicePath: '/eureka/apps/',
  },
});

client.logger.level('debug');

client.start(error => {
  console.log(error || 'Node.js Eureka client started!');
});

process.on('SIGINT', () => {
  client.stop();
});

module.exports = client;
