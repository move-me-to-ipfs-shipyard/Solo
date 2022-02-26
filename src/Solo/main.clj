(ns Solo.main
  (:gen-class)
  (:require
   [clojure.core.async :as a :refer [<! >! <!! >!! chan put! take! go alt! alts! do-alts close! timeout pipe mult tap untap
                                     pub sub unsub mix admix unmix dropping-buffer sliding-buffer pipeline pipeline-async to-chan! thread]]
   [clojure.string]
   [clojure.java.io :as io]

   [Solo.seed]
   [Solo.popcorn]
   [Solo.peanuts]
   [Solo.persimmons]
   [Solo.salt]
   [Solo.avocado]
   [Solo.white-beans]
   [Solo.corn])
  (:import
   (javax.swing JFrame WindowConstants ImageIcon)))

#_(println (System/getProperty "clojure.core.async.pool-size"))
(do (set! *warn-on-reflection* true) (set! *unchecked-math* true))

(defonce stateA (atom nil))
(def ^:dynamic jframe nil)

(defn window
  []
  (let [jframe (JFrame. "crazy thing is - it's true - the Force, the Jedi - all of it, it's all true")]

    (when-let [url (io/resource "icon.png")]
      (.setIconImage jframe (.getImage (ImageIcon. url))))

    (doto jframe
      (.setDefaultCloseOperation WindowConstants/EXIT_ON_CLOSE)
      (.setSize 1600 1200)
      (.setLocation 1700 300)
      (.setVisible true))

    (alter-var-root #'Solo.main/jframe (constantly jframe))

    nil))

(defn reload
  []
  (require
   '[Solo.main]
   :reload))

(defn -main
  [& args]
  (let []
    (reset! stateA {})

    (window)))