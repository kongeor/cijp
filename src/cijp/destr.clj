(ns cijp.destr
  (:require [cijp.funcdata :as fd]))

(defn pplayer [{:keys [name team] :as player}]
  (str name " " team ))

(def bill (first fd/players))

(pplayer bill)

