# credit-services

docker-compose -f docker-compose.yml build "\n"
docker-compose up


Post http://localhost:9494/credits
{
        "credit":{"creditName":"creditnamehere"}, 
        "product":{"productName":"productnamehere", "value":"valuehere"},
        "customer":{"firstName":"firstnamehere", "pesel":"peselhere", "surname":"surnamehere"}
}
