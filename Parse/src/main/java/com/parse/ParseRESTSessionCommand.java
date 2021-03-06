/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse;

import org.json.JSONObject;

/** package */ class ParseRESTSessionCommand extends ParseRESTCommand {

  public static ParseRESTSessionCommand getCurrentSessionCommand(String sessionToken) {
    return new ParseRESTSessionCommand("sessions/me", Method.GET, null, sessionToken);
  }

  public static ParseRESTSessionCommand revoke(String sessionToken) {
    return new ParseRESTSessionCommand("logout", Method.POST, new JSONObject(), sessionToken);
  }

  public static ParseRESTSessionCommand upgradeToRevocableSessionCommand(String sessionToken) {
    return new ParseRESTSessionCommand(
        "upgradeToRevocableSession", Method.POST, new JSONObject(), sessionToken);
  }

  private ParseRESTSessionCommand(String httpPath, Method httpMethod, JSONObject jsonParameters,
      String sessionToken) {
    super(httpPath, httpMethod, jsonParameters, sessionToken);
  }
}
