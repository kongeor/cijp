(ns cijp.hello)

;; We can't avoid that

(defn hello-world []
  (println "Hello World"))

;; Calling a function with no params

(hello-world)

;; With param and docstring

(defn hello
  "Says hello to someone"
  [s]
  (println "Hello" s))

;; Calling with param

(hello "Dude")
