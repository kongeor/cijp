(ns cijp.interop
  (:import [java.util ArrayList Collections]
           [java.awt Point]))

;; Calling static methods

(type (Long/parseLong "5"))

#_(map Integer/parseInt  ["1" "2" "4"])

(defn str->int [x]
  (Integer/parseInt x))

(map str->int ["1" "2" "3"])

;; Calling object methods

(def message "where's the money lebowski")

(. message substring 5 15)

(.substring message 5 15)

;; Constucting objects

(new Point)

(new Point 5 4)

;; Syntactic sugar

(Point. 4 2)

;; Constucting objects and calling methods

(def al (ArrayList.))

(.add al 5)
(.add al 6)
(.add al 1)

(println al)

;; See what happens Larry?

(Collections/sort al)

;; Using the doto macro

(doto
  (ArrayList.)
  (.add 5)
  (.add 6)
  (.add 1))

;; Where is the exception?

(defn slow-add [x y]
  (Thread/sleep 500)
  (+ x y))

(slow-add 5 4)


;; Catching exceptions

(defn div [x y]
  (try
    (/ x y)
    (catch java.lang.ArithmeticException e
      :fail)))

(div 5 2)
(div 5 0)

