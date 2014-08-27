# Rest language detect

A **very** small rest Java web server that easily allows you to detect the language of any given text.

```bash
curl --data "The secret of life is not to do what you like, but to like what you do" http://localhost:8811/
```
(gives you `en`)

```bash
curl --data "A curiosidade matou o gato" http://localhost:8811/
```
(gives you `pt`)

```bash
curl --data "Cattivo bastone non fa buon cane" http://localhost:8811/
```
(gives you `it`)


## Usage
Launch the web server with:

```bash
java -jar target/RestLanguageDetect-1.0-SNAPSHOT-jar-with-dependencies.jar resources/profiles [port] [host]
```

Port and host are optional and will default to `8811` and `localhost` if skipped.

`resources/profiles` is the path where the profiles files are located. It's a mandatory argument so be sure to provide
the correct path.


## Build
If you want to make changes in the code base and build it again you need to use maven:

```bash
mvn clean compile assembly:single
```

This command will build you a self contained jar file for the server.

## Stability and contributions
This is just an experimental projects that is not ready to be run in production (yet!). If you find it useful feel free
to improve it and send pull requests. It would be really cool!

## License
Distributed under [MIT license](LICENSE)



