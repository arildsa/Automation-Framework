#!/usr/bin/env bash
TEST_TASK=${TEST_TASK:='testMulti testSingle testRestApi'}
./gradlew $TEST_TASK