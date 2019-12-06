#!/bin/bash

set -e

# shellcheck source=travis_retry.sh
source "${TRAVIS_BUILD_DIR}/scripts/travis/travis_retry.sh"

if [[ "${COVERAGE_BUILD}" -ne 0 ]]; then
  rle_codecov_coverage_file="${TRAVIS_BUILD_DIR}/rle/target/site/jacoco/jacoco.xml"
  jewellery_and_stones_codecov_coverage_file="${TRAVIS_BUILD_DIR}/jewelery-and-stones/target/site/jacoco/jacoco.xml"
  echo "Sending coverage data to Codecov"
  travis_retry codecov \
    --required \
    --token "${CODECOV_TOKEN}" \
    --file "${rle_codecov_coverage_file}" \
    --file "${jewellery_and_stones_codecov_coverage_file}" \
    --root "${TRAVIS_BUILD_DIR}" -X gcov
fi
