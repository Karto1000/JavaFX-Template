Set-Location .\utils\db

docker build -t mysql-db -f .\db\Dockerfile .
docker run -d -p 8383:3306 --name mysql-db mysql-db
