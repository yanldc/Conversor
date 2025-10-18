# Conversor API

API REST para conversão de moedas, temperaturas e distâncias.

## Tecnologias
- Java 17
- Spring Boot 3.5.6
- Maven

## Como Executar

```bash
# Clonar e navegar para o diretório
cd conversor

# Executar a aplicação
.\mvnw.cmd spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## Endpoints

### Conversão de Moeda
```
GET /convert/currency?from={moeda}&to={moeda}&amount={valor}
```
**Moedas suportadas:** USD, BRL, EUR

**Exemplo:**
```
GET /convert/currency?from=USD&to=BRL&amount=100
```

### Conversão de Temperatura
```
GET /convert/unit/temperature?from={unidade}&to={unidade}&value={valor}
```
**Unidades suportadas:** C (Celsius), F (Fahrenheit)

**Exemplo:**
```
GET /convert/unit/temperature?from=C&to=F&value=25
```

### Conversão de Distância
```
GET /convert/unit/distance?from={unidade}&to={unidade}&value={valor}
```
**Unidades suportadas:** KM (Quilômetros), MI (Milhas)

**Exemplo:**
```
GET /convert/unit/distance?from=KM&to=MI&value=10
```

## Testes

```bash
# Executar testes
.\mvnw.cmd test
```

## Resposta da API

Todas as conversões retornam JSON no formato:
```json
{
  "from": "USD",
  "to": "BRL",
  "originalValue": 100.0,
  "convertedValue": 520.0,
  "type": "currency"
}
```