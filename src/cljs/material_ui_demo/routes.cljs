(ns material-ui-demo.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History)
  (:require [secretary.core :as secretary]
            [goog.events :as gevents]
            [goog.history.EventType :as EventType]
            [re-frame.core :as re-frame]
            [material-ui-demo.events :as events]
            ))

(defn hook-browser-navigation! []
  (doto (History.)
    (gevents/listen
      EventType/NAVIGATE
      (fn [event]
        (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")

  (defroute "/" []
            (re-frame/dispatch [::events/set-active-panel :home-panel]))

  (defroute "/about" []
            (re-frame/dispatch [::events/set-active-panel :about-panel]))

  (defroute "/index" []
            (re-frame/dispatch [::events/set-active-panel :index-panel]))

  (defroute "/index-theme" []
            (re-frame/dispatch [::events/set-active-panel :index-theme-panel]))

  (hook-browser-navigation!))
