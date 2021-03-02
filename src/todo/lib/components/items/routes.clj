(ns todo.lib.components.items.routes
  (:require
    [todo.lib.components.items.api :as api]
    [compojure.route :as route]
    [compojure.core :refer :all])
  (:gen-class))

(defn get-todos-route
  "Endpoint to get all Todos"
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    {
             :status "ok"
             :data (-> (api/get-todos))
             :timestamp (System/currentTimeMillis)
             }})

(defn get-todo-route
  "Endpoint for getting one Todo"
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    {
             :status "ok"
             :data (-> (api/get-todo (req :params)))
             :timestamp (System/currentTimeMillis)
             }})

(defn add-todos-route
  "Endpoint for adding a todo"
  [req]
  {:status  201
   :headers {"Content-Type" "application/json"}
   :body    {
             :status 201
             :data (-> (api/add-todos (req :params)))
             :timestamp (System/currentTimeMillis)
             }})
