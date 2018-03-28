(ns material-ui-demo.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [material-ui-demo.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
