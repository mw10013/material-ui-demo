(ns material-ui-demo.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [material-ui-demo.events :as events]
            [material-ui-demo.routes :as routes]
            [material-ui-demo.views :as views]
            [material-ui-demo.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
