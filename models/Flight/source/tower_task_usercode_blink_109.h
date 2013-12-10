/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.0
 */
#ifndef __TOWER_TASK_USERCODE_BLINK_109_H__
#define __TOWER_TASK_USERCODE_BLINK_109_H__
#ifdef __cplusplus
extern "C" {
#endif
#include <ivory_hw_prim.h>
#include "controloutput_type.h"
#include "data_rate.h"
#include "flightmode_type.h"
#include "gcsstream_timing.h"
#include "gps_type.h"
#include "ivory.h"
#include "mavlink_hil_state_msg.h"
#include "motors_type.h"
#include "optflow_type.h"
#include "radio_info_type.h"
#include "radio_stat_type.h"
#include "sensors_type.h"
#include "tower_primitives.h"
#include "tower_task_loop_blink_109.h"
#include "userinput_type.h"
extern uint8_t armed_114;
extern struct flightmode flightmode_115;
extern uint8_t phase_116;
void nodeInit_blink_109();
void eventhandler_blink_109_per125_120(const uint32_t* n_var0);

#ifdef __cplusplus
}
#endif
#endif /* __TOWER_TASK_USERCODE_BLINK_109_H__ */