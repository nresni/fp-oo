(ns fp-clojure-oo.ch5-class)

(def instance-methods-from-class
  (fn [class]
    (:__instance_methods__ class)))

(def method-from-class
  (fn [message class]
    (message (instance-methods-from-class class))))

(def apply-message-to
  (fn [class instance message args]
    (let [method (or (method-from-class message class)
                     message)]
      (apply method instance args))))

(def send-to
  (fn [object message & args]
    (let [class (eval (:__class_symbol__ object))]
      (apply-message-to class object message args))))

(def make
  (fn [class & args]
    (let [object {:__class_symbol__ (:__own_symbol__ class)}]
      (apply-message-to class object :add-instance-values args))))

(def Point
  {
   :__own_symbol__ 'Point
   :__instance_methods__
   {
    :class-name :__class_symbol__
    :class (fn [this]
             (eval (:__class_symbol__ this)))
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :shift (fn [this xinc yinc]
             (make Point
                   (+ (:x this) xinc)
                   (+ (:y this) yinc)))
    }
   })

(def Holder
  {
   :__own_symbol__ 'Holder
   :__instance_methods__
   {
    :class-name :__class_symbol__
    :class (fn [this]
             (eval (:__class_symbol__ this)))
    :add-instance-values (fn [this held]
                           (assoc this :held held))
    }})
