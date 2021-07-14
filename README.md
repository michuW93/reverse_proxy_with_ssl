# reverse_proxy_with_ssl

`mvn clean install` on both - prov and web projects (it will create .war file), deploy wars on tomcat

**1 way - same domain name, different ports

then install haproxy and run with `haproxy -f haproxy.cfg` command

keys can be generated by: `openssl req -x509 -sha256 -nodes -newkey rsa:2048 -days 365 -keyout localhostWEB.key -out localhostWEB.crt` and then merged into .pem file by `cat localhostWEB.crt localhostWEB.key | tee haproxyWEB.pem`


**2 way - same port, different domain name

haproxySamePort.cfg - one frontend with the same port <br>
hosts - /etc/hosts file with some new hosts <br>
localhostFAKE1.pem and localhostFAKE2.pem - files generated by `openssl req -x509 -out localhostFAKE2.crt -keyout localhostFAKE2.key   -newkey rsa:2048 -nodes -sha256   -subj '/CN=fake2.local' -extensions EXT -config <( \ 
   printf "[dn]\nCN=fake2.local\n[req]\ndistinguished_name = dn\n[EXT]\nsubjectAltName=DNS:fake2.local\nkeyUsage=digitalSignature\nextendedKeyUsage=serverAuth")
` and `cat localhostFAKE2.crt localhostFAKE2.key | tee localhostFAKE2.pem`
<br>
https://serverfault.com/questions/1069439/haproxy-two-applications-on-the-same-port-with-different-certificates
Different ports or differents hostnames (SNI). Tertium non datur.
