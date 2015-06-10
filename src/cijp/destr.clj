(ns cijp.destr
  (:require [cijp.funcdata :as fd]
            [clojure.string :as string]))

;; The problem

(defn pair-sum [coll]
  (let [f (first coll)
        s (second coll)]
    (+ f s)))

(pair-sum [1 2])

;; Array destruction

(defn dp-sum [[a b]]
  (+ a b))

(dp-sum [1 2])

;; Map destruction

(defn pplayer [{:keys [name team] :as player}]
  (str name " " team ))

(def bill (first fd/players))

(pplayer bill)

;; Varags

(defn palindrome? [s]
  (= s (string/reverse s)))

(defn palindromes? [& args]
  (every? palindrome? args))

(palindromes? "asa" "abahaba")

(palindromes? "asa" "abahaba" "abba1")
