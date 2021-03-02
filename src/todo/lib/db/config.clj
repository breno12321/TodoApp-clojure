(ns todo.lib.db.config
  (:require
    [korma.db :as korma]
    [dotenv :refer [env app-env]])
  (:gen-class))

(def db-conn
  (korma/postgres {
                :db (env :DB_NAME)
                :user (env :DB_USER)
                :password (env :DB_PASS)
                }))
(korma/defdb db (korma/postgres {
                                 :db (env :DB_NAME)
                                 :user (env :DB_USER)
                                 :password (env :DB_PASS)
                                 }))