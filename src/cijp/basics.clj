(ns cijp.basics)

;; 1 + 2

(+ 1 2)

;; 1 + 2 + 3

(+ 1 2 3)

;; etc

(+ 1 2 3 4 5 6 7 8 9)

;; etc etc

(* 4 5)

;; !!

(/ 4 10)

;; 5 > 4

(> 5 4)

;; Monotonically increasing ...

(> 5 4 3)



;; Just a reminder

(def x 1234567890123456999)

(type x)

;; This works

(+ x x)

;; But this ... does not ...

(+ x x x x x x x x x x)



;; Nested expressions

;; (1 + 3) * (4 + 5)

(* (+ 1 2) (+ 4 5))

;; Etc ...

(* (+ 1 (/ 5 (* 3 4))) (+ 4 5))

