/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.2
 */
#ifndef __PX4IO_STATUS_TYPES_H__
#define __PX4IO_STATUS_TYPES_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
#include "ivory_serialize.h"
typedef struct px4io_status { bool safety_off;
                              bool failsafe;
                              bool init_ok;
                              bool arm_sync;
                              bool mixer_ok;
                              bool raw_pwm;
                              bool fmu_ok;
                              bool rc_sbus;
                              bool rc_dsm;
                              bool rc_ppm;
                              bool rc_ok;
                              bool outputs_armed;
                              bool override;
} px4io_status;
void px4io_status_get_le (const uint8_t * n_var0, uint32_t n_var1, struct px4io_status * n_var2);
void px4io_status_get_be (const uint8_t * n_var0, uint32_t n_var1, struct px4io_status * n_var2);
void px4io_status_set_le (uint8_t * n_var0, uint32_t n_var1, const struct px4io_status * n_var2);
void px4io_status_set_be (uint8_t * n_var0, uint32_t n_var1, const struct px4io_status * n_var2);

#ifdef __cplusplus
}
#endif
#endif /* __PX4IO_STATUS_TYPES_H__ */