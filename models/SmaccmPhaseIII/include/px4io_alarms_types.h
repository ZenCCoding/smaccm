/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.2
 */
#ifndef __PX4IO_ALARMS_TYPES_H__
#define __PX4IO_ALARMS_TYPES_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
#include "ivory_serialize.h"
typedef struct px4io_alarms { bool vservo_fault;
                              bool pwm_error;
                              bool rc_lost;
                              bool fmu_lost;
                              bool acc_current;
                              bool servo_current;
                              bool temperature;
                              bool vbatt_low;
} px4io_alarms;
void px4io_alarms_get_le (const uint8_t * n_var0, uint32_t n_var1, struct px4io_alarms * n_var2);
void px4io_alarms_get_be (const uint8_t * n_var0, uint32_t n_var1, struct px4io_alarms * n_var2);
void px4io_alarms_set_le (uint8_t * n_var0, uint32_t n_var1, const struct px4io_alarms * n_var2);
void px4io_alarms_set_be (uint8_t * n_var0, uint32_t n_var1, const struct px4io_alarms * n_var2);

#ifdef __cplusplus
}
#endif
#endif /* __PX4IO_ALARMS_TYPES_H__ */