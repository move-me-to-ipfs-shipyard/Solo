#!/bin/bash

repl(){
  clj \
    -J-Dclojure.core.async.pool-size=1 \
    -X:repl Ripley.core/process \
    :main-ns Solo.main
}

main(){
  clojure \
    -J-Dclojure.core.async.pool-size=1 \
    -M -m Solo.main
}

uberjar(){

  clojure \
    -X:identicon Zazu.core/process \
    :word '"Solo"' \
    :filename '"out/identicon/icon.png"' \
    :size 256

  rm -rf out/*.jar
  clojure \
    -X:uberjar Genie.core/process \
    :main-ns Solo.main \
    :filename "\"out/Solo-$(git rev-parse --short HEAD).jar\"" \
    :paths '["src" "out/identicon"]'
}

release(){
  uberjar
}

"$@"