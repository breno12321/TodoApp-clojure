# todo - WIP 🚧 

`A Clojure library designed to ... well, that part is up to you.` 

Ok Lein... I take from here, this is a simple project for a REST API using clojure for learning purposes.

## Development environment

⚙Specs:
- Postgres: 13.2-1.pgdg100+1
- Clojure: 1.10.2
- Lein: Leiningen 2.9.5 on Java 11.0.10 OpenJDK 64-Bit Server VM
- Computer: 
  - i5 6600k
  - 16GB DDR4 2400Mhz
  - Ubuntu 20.04

## Step by step to execute 💨

First of all, make sure your Postgres server is up and running - [Docker](https://hub.docker.com/_/mysql) enviroments make its use easier. Then you can clone the repository with:  

```bash
git clone DESIRED_DIR_NAME git@github.com:breno12321/TodoApp-clojure.git
```

Done clonning, you can now configure the env file, doing 

```bash
vi .env.development
```

After setting up the enviroment you can run: 
```bash
lein deps
```
Then Leiningen will get all the dependencies, with them all setup you can run:

```bash
lein run
``` 
 
It will be running on `http://localhost:3000` for development purposes👨‍💻, hot reload for file modifications due to dev profile.

## Documentation 📕

FIXME 🚧

## Postman

The postman requests are in the [doc](doc/clojure-todo.postman_collection.json) folder

## Folder Structure

```
.
├── dbsetup
│   └── create-items.sql
└── todo
    ├── core.clj
    └── lib
        ├── components
        │   └── items
        │       ├── api.clj
        │       ├── model.clj
        │       └── routes.clj
        ├── db
        │   └── config.clj
        └── routes.clj
```

## License

Copyright © 2021 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.


### Resources

- https://itnext.io/getting-started-with-clojure-e8f207ff8eab
- https://github.com/korma/Korma
- https://github.com/ring-clojure
- https://clojure.org/index
- https://weavejester.github.io/compojure/index.html
- https://weavejester.github.io/compojure/compojure.core.html#var-context
