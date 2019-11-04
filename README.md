# Password Generation Library
A minimalistic library for generating random passwords.

## Features
* Adjustable length for the passwords (default: 50)
* Passwords can be re-shuffled after creation
* Easy to use character sets
* Adjustable character sets
* Printable passwords

## Example
```java
// create a generator
Generator generator = new Generator();

// select character sets (capital letters are included automatically)
// (You can toggle them off with the toggleCase() method.)
generator.use(Set.ALPHABET, Set.DIGITS, Set.BRACKETS, Set.SPECIAL);

// generate and print new password
System.out.print(generator.generate());

// output -> Q0>[2d$}w§[74=00¥b<$5)[6g)1)([*2£0ABg?
```

## Character sets
### Alphabetic
```
abcdefghijklmnopqrstuvwxyäöå
```

### Numeric
```
0123456789
```

### Brackets
```
()[]{}<>
```

### Special
```
!£$%&?+#€¤¢¥¦§©+*/-=
```
