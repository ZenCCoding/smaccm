/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.0
 */
#ifndef __MAVLINK_MANUAL_SETPOINT_MSG_H__
#define __MAVLINK_MANUAL_SETPOINT_MSG_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
#include "mavlinkSendModule.h"
#include "mavlink_pack_ivory.h"
struct manual_setpoint_msg {
    uint32_t time_boot_ms;
    float roll;
    float pitch;
    float yaw;
    float thrust;
    uint8_t mode_switch;
    uint8_t manual_override_switch;
} __attribute__((__packed__));
void mavlink_manual_setpoint_msg_send(const struct manual_setpoint_msg* n_var0,
                                      uint8_t* n_var1, uint8_t n_var2[80U]);
void mavlink_manual_setpoint_unpack(struct manual_setpoint_msg* n_var0, const
                                    uint8_t* n_var1);

#ifdef __cplusplus
}
#endif
#endif /* __MAVLINK_MANUAL_SETPOINT_MSG_H__ */