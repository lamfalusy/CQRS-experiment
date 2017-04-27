FROM java:8
EXPOSE 9092
RUN apt-get update && apt-get -y install nano && apt-get -y install wget && mkdir /home/kafka && cd /home/kafka && wget http://xenia.sote.hu/ftp/mirrors/www.apache.org/kafka/0.10.2.0/kafka_2.11-0.10.2.0.tgz && tar -xzf kafka_2.11-0.10.2.0.tgz