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
             :timestamp (.getTime (new java.util.Date))
             }})

(defn get-todo-route
  "Endpoint for getting one Todo"
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    {
             :status "ok"
             :data (-> (api/get-todo (req :params)))
             :timestamp (.getTime (new java.util.Date))
             }})

(defn toggle-todo-route
  "Endpoint for toggle done/undone one Todo"
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    {
             :status "ok"
             :data (-> (api/toggle-todo (req :params)))
             :timestamp (.getTime (new java.util.Date))
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

(defn update-todos-route
  "Endpoint for update a todo"
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    {
             :status 200
             :data (-> (api/update-todo (req :params)))
             :timestamp (System/currentTimeMillis)
             }})

(defn delete-todo-route
  "Endpoint for delete a todo"
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    {
             :status 200
             :data {:affectedRows (-> (api/del-todo (req :params)))}
             :timestamp (System/currentTimeMillis)
             }})

(defn items-router []
  (context "/todos" []
    (GET "/" [] get-todos-route)
    (GET "/:id" [] get-todo-route)
    (PATCH "/:id/toggle" [] toggle-todo-route)
    (PATCH "/:id" [] update-todos-route)
    (POST "/" [] add-todos-route)
    (DELETE "/:id" [] delete-todo-route)
    ))