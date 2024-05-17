# 1. Zarządanie książkami

Spis treści:
1) Opis
2) Lista zaimplementowanych funkcjonalności
3) Wymagania
4) Uruchamianie

## 1) Opis

Aplikacja pozwalająca na graficzne zarządzanie książkami.
Posiada wbudowaną bazę 25 książek które można dodawać oraz usuwać.
Książki można wyszukiwać za pomocą wyrażeń regularnych w polu wyszukiwania,
oraz posortować według danego pola. Aplikacja przechowywuje listę książek
w pliku nazwanym `books.data`. Domyślny zestaw książek ładowany jest
tylko w przypadku gdy plik nie istnieje.

## 2) Lista zaimplementowanych funkcjonalności
- dodawanie książek
- usuwanie książek
- wyświetlanie informacji o książce
- wyszukiwanie z użyciem wyrażeń regularnych
- sortowanie po kilku atrybutach książek

## 3) Wymagania

- Java 19

## 4) Uruchamianie

```sh
# Linux, MacOS
chmod +x ./run.sh
./run.sh

# Windows
./run.bat
```
